package api;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.ICreature;
import model.Maps;

public class MapLoader {
	public static boolean saveMapTo(Maps map, String filePath) {
		try {
			File file = new File(filePath);
			if (file.isDirectory())
				return false;

			ObjectOutputStream objOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
			objOut.writeObject(map);
			objOut.close();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static Maps loadMapFrom(String filePath) {
		try {
			File file = new File(filePath);
			if (file.isDirectory())
				return null;

			ObjectInputStream objIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
			Maps mapOut = (Maps) objIn.readObject();
			objIn.close();
			return mapOut;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
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
