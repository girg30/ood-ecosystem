package com.annvcit.controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.ImageIcon;

import com.annvcit.model.AAnimal;
import com.annvcit.model.ACarnivore;
import com.annvcit.model.AHerbivore;
import com.annvcit.model.APlant;
import com.annvcit.model.Rabbit;
import com.annvcit.model.Willow;
import com.annvcit.model.ImplBreedState;
import com.annvcit.model.ImplHungryState;
import com.annvcit.model.ImplStarvedState;
import com.annvcit.model.InteractionFactory;
import com.annvcit.model.Message;
import com.annvcit.model.Wolf;
import com.annvcit.util.ImageResource;
import com.annvcit.util.Observer;

/**
 * Lợp hiện thực, thực hiện công việc tạo ra các sản phẩm thành phần cụ thể cần cho 1 hệ sinh thái cụ thể. Ở đây là Fiinish
 */
public class ImplFinnishFactory implements ICreatureFactory, Observer {

	private List<ACarnivore> wolfList;
	private List<AHerbivore> rabbitList;
	private List<APlant> willowList;
	
	private InteractionFactory interactionFactory;
	
	Random random = new Random();

	public ImplFinnishFactory() {}
	
	public ImplFinnishFactory(int wolfs, int rabbits, int willowes) {
		interactionFactory = new InteractionFactory();
		wolfList = new CopyOnWriteArrayList<>();
		rabbitList = new CopyOnWriteArrayList<>();
		willowList = new CopyOnWriteArrayList<>();

		// initialize objects
		createCarnivore();
		createHerbivore();
		createPlant();

	}

	@Override
	public void draw(Graphics g) {
		respawn();
		for (APlant willow : willowList) willow.draw(g);
		
		Iterator<ACarnivore> iteratorWolf = wolfList.iterator();
		while (iteratorWolf.hasNext()) {
			Wolf wolf = ((Wolf) iteratorWolf.next());
			wolf.draw(g);
		}
		
		Iterator<AHerbivore> iteratorRabbit = rabbitList.iterator();
		while (iteratorRabbit.hasNext()) {
			Rabbit rabbit = ((Rabbit) iteratorRabbit.next());
			rabbit.draw(g);
			
		}
		
		g.setColor(Color.WHITE);
		g.drawString("amount of Rabbit: " + rabbitList.size() , 20, 20);
		g.drawString("amount of Wolf: " + wolfList.size() , 20, 40);
		g.drawString("amount of Willow: " + willowList.size() , 20, 60);

	}
	
	public void askCarnivoreMove() {
		for (ACarnivore wolf : wolfList) {
			if (wolf.getCurrentState() instanceof ImplHungryState) {
				wolf.goHunt(this.rabbitList);
			} else if (wolf.getCurrentState() instanceof ImplStarvedState) {
				wolf.goFight(wolfList);
			} else if (wolf.getCurrentState() instanceof ImplBreedState){
				wolf.goBreed(wolfList);
			}
		}
	}
	
	@Override
	public void askHerbivoreMove() {
		for (AHerbivore rabbit : rabbitList) {
			if (rabbit.getCurrentState() instanceof ImplHungryState) {
				rabbit.goEat(this.willowList);
			} else if (rabbit.getCurrentState() instanceof ImplBreedState) {
				rabbit.goBreed(rabbitList);
			} else if(rabbit.getCurrentState() instanceof ImplStarvedState){
				rabbit.goFight(rabbitList);
			}
		}
	}
	
	@Override
	public void update(Object... objects) {
		Message message = (Message) objects[0];
		
		
		switch (message.getContent()) {
		case Message.HUNT:
			Wolf wolf = (Wolf) objects[1];
			Rabbit rabbit = (Rabbit) objects[2];
			
			interactionFactory.chInteraction(wolf, rabbit).interact();
			rabbit.removeObserver(this);
			rabbitList.remove(rabbit);
			break;
		case Message.EAT:
			rabbit = (Rabbit) objects[1];
			Willow willow = (Willow) objects[2];
			interactionFactory.hpInteraction(rabbit, willow).interact();
			willow.removeObserver(this);
			willowList.remove(willow);
			break;
			
		case Message.REMOVE_ME:
			Object o = objects[1];
			if (o instanceof Wolf) {
				((Wolf) o).removeObserver(this);
				wolfList.remove(o);
			} else if (o instanceof Rabbit) {
				((Rabbit) o).removeObserver(this);
				rabbitList.remove(o);
			}
			break;
		case Message.FIGHT_ME:
			if(objects[1] instanceof Wolf){
				ACarnivore wolf1 = (ACarnivore) objects[1];
				ACarnivore wolf2 = (ACarnivore) objects[2];
				
				ACarnivore victim = (ACarnivore)interactionFactory.cchhInteraction(wolf1,wolf2).interact();
	
				victim.removeObserver(this);
				wolfList.remove(victim);
			}else{
				AHerbivore rabbit1 = (AHerbivore) objects[1];
				AHerbivore rabbit2 = (AHerbivore) objects[2];
				
				AHerbivore victim = (AHerbivore)interactionFactory.cchhInteraction(rabbit1,rabbit2).interact();
	
				victim.removeObserver(this);
				rabbitList.remove(victim);
			}
			break;
		case Message.MAKE_BABY:
			AAnimal me = (AAnimal) objects[1];
			AAnimal you = (AAnimal) objects[2];
			AAnimal baby = (AAnimal) interactionFactory.cchhInteraction(me,you).interact();
			if (baby instanceof Wolf && baby.getBody() != null) {
				baby.addObserver(this);
				wolfList.add((Wolf)baby);
			} else if (baby instanceof Rabbit && baby.getBody() != null) {
				baby.addObserver(this);
				int size = rabbitList.size();
				rabbitList.add((Rabbit)baby);
				System.out.println(rabbitList.size() > size);
			}
			
			break;
		}
	}
	
	
	@Override
	public void createCarnivore() {
		int numSex = -1;
		int numState = -1;
		for (int i = 0; i < 5; i++) {
			Wolf wolf = new Wolf(random.nextInt(800), random.nextInt(600));
			
			numSex = random.nextInt(2);
			numState = random.nextInt(2);
			
			wolf.setSex(AAnimal.MALE);
			if (numSex == 1) wolf.setSex(AAnimal.FEMALE);
			
			wolf.setAvartar(wolf.isMale() ? ImageResource.LION_MALE_NORMAL : ImageResource.LION_FEMALE_NORMAL);
			wolf.setCurrentState(wolf.getNormalState());
			if (numState == 1) wolf.setCurrentState(wolf.getHungryState());
			
			wolf.addObserver(this);
			wolfList.add(wolf);
			
		}
	}

	@Override
	public void createHerbivore() {
		int numSex = -1;
		int numState = -1;
		
		for (int i = 0; i < 10; i++) {
			Rabbit rabbit = new Rabbit(random.nextInt(800), random
					.nextInt(600));
			
			numSex = random.nextInt(2);
			numState = random.nextInt(2);
			
			rabbit.setSex(AAnimal.MALE);
			if (numSex == 1) rabbit.setSex(AAnimal.FEMALE);
			
			rabbit.setAvartar(rabbit.isMale() ? ImageResource.ANTELOPE_MALE_NORMAL : ImageResource.ANTELOPE_FEMALE_NORMAL);
			if (numState == 1) rabbit.setCurrentState(rabbit.getHungryState());
			
			rabbit.setPower(random.nextInt(900) + 300);
			rabbit.addObserver(this);
			rabbitList.add(rabbit);
		}
	}

	@Override
	public void createPlant() {
		for (int i = 0; i < 15; i++) {
			APlant willow = new Willow(random.nextInt(800), random.nextInt(600));
			willow.addObserver(this);
			willowList.add(willow);
		}
	}

	public List<AHerbivore> getRabbitList() { return this.rabbitList; }
	
	public void respawn() {
		int wolfListSize = wolfList.size();
		int rabbitListSize = rabbitList.size();
		int willowListSize = willowList.size();
		
		if (wolfListSize <= 2) {
			createCarnivore();
		}
		
		if (rabbitListSize <= 5) {
			createHerbivore();
		}
		
		if (willowListSize <= 7) {
			createPlant();
		}
	}

	@Override
	public void drawBackground(Graphics g) {
		ImageIcon icon = new ImageIcon(ImageResource.FINNISH_BACKGROUND_TILE);
		Image landTile = icon.getImage();
		int x=0, y=0;
		for(int i = 0; i<50;i++){
			for(int j = 0; j<50;j++){
				g.drawImage(landTile, x, y,icon.getIconWidth(), icon.getIconHeight(),null);
				x+= icon.getIconWidth();
			}
			x = 0;
			y+= icon.getIconHeight();
		}
		
	}
	
}

