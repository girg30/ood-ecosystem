package com.annvcit.model;

import java.util.Random;

import com.annvcit.util.ImageResource;

/**
 * Tương tác sinh sản giữa 2 con động vật opposite sex
 * */
public class ImplBreedInteraction implements IInteraction {

	private AAnimal female;
	private AAnimal male;

	public ImplBreedInteraction(AAnimal f, AAnimal m) {
		this.female = f;
		this.male = m;
	}

	@Override
	public Object interact() {
		AAnimal child = null;
		int x = (male.x + female.x) / 2;
		int y = (male.y + female.y) / 2;
		// int width = 8;
		// int height = 8;

		Random random = new Random();
		if (male instanceof Lion && female instanceof Lion) {
			child = new Lion(x, y);

			if (random.nextInt(2) == 1)
				child.setSex(AAnimal.MALE);
			else
				child.setSex(AAnimal.FEMALE);
			child.isChild(true);

			child.setAvartar(child.isMale() ? ImageResource.LION_MALE_CHILD_NORMAL : ImageResource.LION_FEMALE_CHILD_NORMAL);
		} else if (male instanceof Antelope && female instanceof Antelope) {
			child = new Antelope(x, y);

			if (random.nextInt(2) == 1)
				child.setSex(AAnimal.MALE);
			else
				child.setSex(AAnimal.FEMALE);
			child.isChild(true);

			child.setAvartar(child.isMale() ? ImageResource.ANTELOPE_MALE_NORMAL : ImageResource.ANTELOPE_FEMALE_NORMAL);
		} else if (male instanceof Wolf && female instanceof Wolf) {
			child = new Wolf(x, y);
			
			if (random.nextInt(2) == 1)
				child.setSex(AAnimal.MALE);
			else
				child.setSex(AAnimal.FEMALE);
			child.isChild(true);

			child.setAvartar(child.isMale() ? ImageResource.LION_MALE_CHILD_NORMAL : ImageResource.LION_FEMALE_CHILD_NORMAL);
		} else if (male instanceof Rabbit && female instanceof Rabbit) {
			child = new Rabbit(x, y);
			
			child = new Antelope(x, y);

			if (random.nextInt(2) == 1)
				child.setSex(AAnimal.MALE);
			else
				child.setSex(AAnimal.FEMALE);
			child.isChild(true);

			child.setAvartar(child.isMale() ? ImageResource.ANTELOPE_MALE_NORMAL : ImageResource.ANTELOPE_FEMALE_NORMAL);
		}

		// child.getBody().width = width;
		// child.getBody().height = height;
		child.setRadius(100);

		male.setCurrentState(male.getHungryState());
		female.setCurrentState(female.getHungryState());

		male.setWantBreed(-10);
		female.setWantBreed(-10);

		return child;
	}

}
