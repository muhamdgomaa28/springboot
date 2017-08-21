package com.controler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.model.Shipwreck;


public class ShipwreckStub {
	private static Map<Long, Shipwreck> wrecks = new HashMap<Long, Shipwreck>();
	private static Long idIndex = 3L;

	//populate initial wrecks
	static {
		Shipwreck a = new Shipwreck(1, "U869", "A very deep German UBoat", "FAIR", 200, 44.12, 138.44, 1994);
		wrecks.put(1L, a);
		Shipwreck b = new Shipwreck(2, "Thistlegorm", "British merchant boat in the Red Sea", "GOOD", 80, 44.12, 138.44, 1994);
		wrecks.put(2L, b);
		Shipwreck c = new Shipwreck(3, "S.S. Yongala", "A luxury passenger ship wrecked on the great barrier reef", "FAIR", 50, 44.12, 138.44, 1994);
		wrecks.put(3L, c);
	}

	public static List<Shipwreck> list() {
		return new ArrayList<Shipwreck>(wrecks.values());
	}

	public static Shipwreck create(Shipwreck wreck) {
		idIndex += idIndex;
		wreck.setId(45);
		wrecks.put(idIndex, wreck);
		return wreck;
	}

	public static Shipwreck get(Long id) {
		return wrecks.get(id);
	}

	public static Shipwreck update(Long id, Shipwreck wreck) {
		wrecks.put(id, wreck);
		return wreck;
	}

	public static Shipwreck delete(Long id) {
		return wrecks.remove(id);
	}
}
