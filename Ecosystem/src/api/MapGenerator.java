package api;

import java.util.Random;

import model.ICreature;
import model.Maps;
import model.MyPosition;
import model.animal.Huou;
import model.animal.Lion;
import model.animal.Wolf;
import model.plant.Grass;
import model.plant.Plant;

public class MapGenerator {
	private static Random rd = new Random();

	public static Maps createRandomMap(int width, int height) {

		ICreature[][] map = new ICreature[height][width];

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				map[y][x] = new Grass(new MyPosition(x, y));
			}
		}

		int x;
		int y;
		int numbers = rd.nextInt(6) + 2;
		// create lion
		for (int i = 0; i < numbers; i++) {
			x = rd.nextInt(width);
			y = rd.nextInt(height);
			map[y][x] = new Lion(new MyPosition(x, y));
		}

		numbers = rd.nextInt(10) + 3;
		// create wolf
		for (int i = 0; i < numbers; i++) {
			x = rd.nextInt(width);
			y = rd.nextInt(height);
			map[y][x] = new Wolf(new MyPosition(x, y));
		}

		numbers = rd.nextInt(10) + 5;
		// create huou
		for (int i = 0; i < numbers; i++) {
			x = rd.nextInt(width);
			y = rd.nextInt(height);
			map[y][x] = new Huou(new MyPosition(x, y));
		}

		numbers = rd.nextInt(15) + 5;
		// create plant
		for (int i = 0; i < numbers; i++) {
			x = rd.nextInt(width);
			y = rd.nextInt(height);
			map[y][x] = new Plant(new MyPosition(x, y));
		}

		return new Maps(map);
	}

	public static void printMap(Maps map) {
		for (ICreature[] rows : map.getMap()) {
			for (ICreature cell : rows) {
				System.out.print(cell + "\t");
			}
			System.out.println();
		}
	}

}
