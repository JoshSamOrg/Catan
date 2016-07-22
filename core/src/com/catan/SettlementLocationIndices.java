package com.catan;

public class SettlementLocationIndices {
	private static boolean settlementLocations[]; //holds the information for whether or not a settlement location is occupied or not.
	private static boolean two = false;
	private static int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0;

	public SettlementLocationIndices() {
		settlementLocations = new boolean[177];
		for (int i = 0; i < settlementLocations.length; i++) {
			settlementLocations[i] = false;
		}
	}
	/*
	 * x the x coordinate of a settlement location
	 * y the y coordinate of a settlement location
	 * Returns the index of the newly marked hex (from the settlementLocations array).
	 */
	public static int getHexLocations(int x, int y) {
		if (x == 141 && y == 438) {
			return 0;
		} else if (x == 119 && y == 401) {
			return 1;
		} else if (x == 119 && y == 426) {
			return 2;
		} else if (x == 98 && y == 388) {
			return 3;
		} else if (x == 98 && y == 363) {
			return 4;
		} else if (x == 77 && y == 351) {
			return 5;
		} else if (x == 77 && y == 327) {
			return 6;
		} else if (x == 55 && y == 314) {
			return 7;
		} else if (x == 55 && y == 290) {
			return 8;
		} else if (x == 76 && y == 278) {
			return 9;
		} else if (x == 76 && y == 254) {
			return 10;
		} else if (x == 98 && y == 241) {
			return 11;
		} else if (x == 98 && y == 217) {
			return 12;
		} else if (x == 119 && y == 204) {
			return 13;
		} else if (x == 119 && y == 180) {
			return 14;
		} else if (x == 140 && y == 168) {
			return 15;
		} else if (x == 162 && y == 180) {
			return 16;
		} else if (x == 183 && y == 168) {
			return 17;
		} else if (x == 205 && y == 180) {
			return 18;
		} else if (x == 226 && y == 168) {
			return 19;
		} else if (x == 248 && y == 180) {
			return 20;
		} else if (x == 269 && y == 168) {
			return 21;
		} else if (x == 290 && y == 180) {
			return 22;
		} else if (x == 311 && y == 169) {
			return 23;
		} else if (x == 333 && y == 180) {
			return 24;
		} else if (x == 354 && y == 169) {
			return 25;
		} else if (x == 376 && y == 180) {
			return 26;
		} else if (x == 397 && y == 169) {
			return 27;
		} else if (x == 419 && y == 180) {
			return 28;
		} else if (x == 440 && y == 169) {
			return 29;
		} else if (x == 461 && y == 180) {
			return 30;
		} else if (x == 482 && y == 169) {
			return 31;
		} else if (x == 504 && y == 181) {
			return 32;
		} else if (x == 504 && y == 205) {
			return 33;
		} else if (x == 525 && y == 218) {
			return 34;
		} else if (x == 525 && y == 242) {
			return 35;
		} else if (x == 546 && y == 254) {
			return 36;
		} else if (x == 546 && y == 279) {
			return 37;
		} else if (x == 567 && y == 291) {
			return 38;
		} else if (x == 567 && y == 316) {
			return 39;
		} else if (x == 547 && y == 328) {
			return 40;
		} else if (x == 546 && y == 352) {
			return 41;
		} else if (x == 525 && y == 365) {
			return 42;
		} else if (x == 525 && y == 389) {
			return 43;
		} else if (x == 504 && y == 402) {
			return 44;
		} else if (x == 503 && y == 426) {
			return 45;
		} else if (x == 482 && y == 438) {
			return 46;
		} else if (x == 461 && y == 426) {
			return 47;
		} else if (x == 439 && y == 438) {
			return 48;
		} else if (x == 418 && y == 426) {
			return 49;
		} else if (x == 396 && y == 438) {
			return 50;
		} else if (x == 375 && y == 426) {
			return 51;
		} else if (x == 353 && y == 438) {
			return 52;
		} else if (x == 332 && y == 426) {
			return 53;
		} else if (x == 311 && y == 438) {
			return 54;
		} else if (x == 290 && y == 426) {
			return 55;
		} else if (x == 269 && y == 437) {
			return 56;
		} else if (x == 247 && y == 425) {
			return 57;
		} else if (x == 226 && y == 437) {
			return 58;
		} else if (x == 205 && y == 425) {
			return 59;
		} else if (x == 183 && y == 438) {
			return 60;
		} else if (x == 162 && y == 426) {
			return 61;
		} else if (x == 204 && y == 401) {
			return 62;
		} else if (x == 183 && y == 389) {
			return 63;
		} else if (x == 162 && y == 401) {
			return 64;
		} else if (x == 140 && y == 389) {
			return 65;
		} else if (x == 140 && y == 364) {
			return 66;
		} else if (x == 162 && y == 351) {
			return 67;
		} else if (x == 183 && y == 364) {
			return 68;
		} else if (x == 119 && y == 351) {
			return 69;
		} else if (x == 98 && y == 315) {
			return 70;
		} else if (x == 119 && y == 327) {
			return 71;
		} else if (x == 141 && y == 315) {
			return 72;
		} else if (x == 162 && y == 327) {
			return 73;
		} else if (x == 98 && y == 290) {
			return 74;
		} else if (x == 119 && y == 279) {
			return 75;
		} else if (x == 140 && y == 291) {
			return 76;
		} else if (x == 162 && y == 278) {
			return 77;
		} else if (x == 183 && y == 291) {
			return 78;
		} else if (x == 184 && y == 315) {
			return 79;
		} else if (x == 119 && y == 253) {
			return 80;
		} else if (x == 141 && y == 242) {
			return 81;
		} else if (x == 161 && y == 254) {
			return 82;
		} else if (x == 141 && y == 216) {
			return 83;
		} else if (x == 183 && y == 242) {
			return 84;
		} else if (x == 184 && y == 216) {
			return 85;
		} else if (x == 162 && y == 204) {
			return 86;
		} else if (x == 205 && y == 204) {
			return 87;
		} else if (x == 247 && y == 401) {
			return 88;
		} else if (x == 227 && y == 388) {
			return 89;
		} else if (x == 227 && y == 364) {
			return 90;
		} else if (x == 205 && y == 351) {
			return 91;
		} else if (x == 205 && y == 328) {
			return 92;
		} else if (x == 226 && y == 315) {
			return 93;
		} else if (x == 226 && y == 291) {
			return 94;
		} else if (x == 205 && y == 279) {
			return 95;
		} else if (x == 205 && y == 254) {
			return 96;
		} else if (x == 227 && y == 242) {
			return 97;
		} else if (x == 226 && y == 217) {
			return 98;
		} else if (x == 247 && y == 204) {
			return 99;
		} else if (x == 290 && y == 401) {
			return 100;
		} else if (x == 269 && y == 388) {
			return 101;
		} else if (x == 270 && y == 365) {
			return 102;
		} else if (x == 248 && y == 351) {
			return 103;
		} else if (x == 248 && y == 328) {
			return 104;
		} else if (x == 269 && y == 316) {
			return 105;
		} else if (x == 269 && y == 292) {
			return 106;
		} else if (x == 247 && y == 279) {
			return 107;
		} else if (x == 248 && y == 254) {
			return 108;
		} else if (x == 268 && y == 242) {
			return 109;
		} else if (x == 269 && y == 217) {
			return 110;
		} else if (x == 290 && y == 205) {
			return 111;
		} else if (x == 332 && y == 402) {
			return 112;
		} else if (x == 311 && y == 389) {
			return 113;
		} else if (x == 312 && y == 366) {
			return 114;
		} else if (x == 290 && y == 353) {
			return 115;
		} else if (x == 290 && y == 329) {
			return 116;
		} else if (x == 311 && y == 316) {
			return 117;
		} else if (x == 311 && y == 292) {
			return 118;
		} else if (x == 290 && y == 279) {
			return 119;
		} else if (x == 290 && y == 255) {
			return 120;
		} else if (x == 311 && y == 242) {
			return 121;
		} else if (x == 311 && y == 218) {
			return 122;
		} else if (x == 333 && y == 205) {
			return 123;
		} else if (x == 375 && y == 402) {
			return 124;
		} else if (x == 355 && y == 389) {
			return 125;
		} else if (x == 355 && y == 366) {
			return 126;
		} else if (x == 333 && y == 353) {
			return 127;
		} else if (x == 333 && y == 328) {
			return 128;
		} else if (x == 354 && y == 316) {
			return 129;
		} else if (x == 354 && y == 292) {
			return 130;
		} else if (x == 333 && y == 279) {
			return 131;
		} else if (x == 333 && y == 255) {
			return 132;
		} else if (x == 354 && y == 242) {
			return 133;
		} else if (x == 354 && y == 218) {
			return 134;
		} else if (x == 375 && y == 205) {
			return 135;
		} else if (x == 418 && y == 402) {
			return 136;
		} else if (x == 397 && y == 390) {
			return 137;
		} else if (x == 397 && y == 365) {
			return 138;
		} else if (x == 376 && y == 353) {
			return 139;
		} else if (x == 376 && y == 328) {
			return 140;
		} else if (x == 397 && y == 316) {
			return 141;
		} else if (x == 397 && y == 291) {
			return 142;
		} else if (x == 375 && y == 279) {
			return 143;
		} else if (x == 375 && y == 254) {
			return 144;
		} else if (x == 397 && y == 242) {
			return 145;
		} else if (x == 397 && y == 217) {
			return 146;
		} else if (x == 418 && y == 205) {
			return 147;
		} else if (x == 461 && y == 402) {
			return 148;
		} else if (x == 440 && y == 389) {
			return 149;
		} else if (x == 440 && y == 364) {
			return 150;
		} else if (x == 419 && y == 353) {
			return 151;
		} else if (x == 419 && y == 328) {
			return 152;
		} else if (x == 440 && y == 316) {
			return 153;
		} else if (x == 440 && y == 291) {
			return 154;
		} else if (x == 418 && y == 280) {
			return 155;
		} else if (x == 418 && y == 254) {
			return 156;
		} else if (x == 440 && y == 242) {
			return 157;
		} else if (x == 440 && y == 218) {
			return 158;
		} else if (x == 461 && y == 205) {
			return 159;
		} else if (x == 483 && y == 389) {
			return 160;
		} else if (x == 483 && y == 364) {
			return 161;
		} else if (x == 461 && y == 352) {
			return 162;
		} else if (x == 461 && y == 328) {
			return 163;
		} else if (x == 483 && y == 316) {
			return 164;
		} else if (x == 482 && y == 291) {
			return 165;
		} else if (x == 462 && y == 279) {
			return 166;
		} else if (x == 462 && y == 254) {
			return 167;
		} else if (x == 482 && y == 242) {
			return 168;
		} else if (x == 482 && y == 217) {
			return 169;
		} else if (x == 504 && y == 352) {
			return 170;
		} else if (x == 504 && y == 328) {
			return 171;
		} else if (x == 525 && y == 316) {
			return 172;
		} else if (x == 525 && y == 291) {
			return 173;
		} else if (x == 503 && y == 279) {
			return 174;
		} else if (x == 503 && y == 254) {
			return 175;
		}
		return 176;
	}
	/*
	 * x the x coordinate of the settlement location
	 * y the y coordinate of the settlement location
	 * Returns whether the placement of the settlement follows the two-away rule.
	 */
	public static boolean twoAway(int x, int y) {
		a = validPositions.findHex(x, y + 10);
		b = validPositions.findHex(x, y + 30);

		if (a == b && b != 72) {
			System.out.println("here99");
			CatanPieces.findSettlement(x - 20, y);
			c = getHexLocations(
					CatanPieces.getPositions().get(
							CatanPieces.getSettlementIndexX()),
					CatanPieces.getPositions().get(
							CatanPieces.getSettlementIndexY()));
			CatanPieces.findSettlement(x + 20, y);
			d = getHexLocations(
					CatanPieces.getPositions().get(
							CatanPieces.getSettlementIndexX()),
					CatanPieces.getPositions().get(
							CatanPieces.getSettlementIndexY()));
			CatanPieces.findSettlement(x, y - 20);
			e = getHexLocations(
					CatanPieces.getPositions().get(
							CatanPieces.getSettlementIndexX()),
					CatanPieces.getPositions().get(
							CatanPieces.getSettlementIndexY()));

			if (settlementLocations[c] == false
					&& settlementLocations[d] == false
					&& settlementLocations[e] == false) {
				two = true;
			} else {
				two = false;
			}
		} else {
			System.out.println("here100");
			CatanPieces.findSettlement(x - 20, y);
			c = getHexLocations(
					CatanPieces.getPositions().get(
							CatanPieces.getSettlementIndexX()),
					CatanPieces.getPositions().get(
							CatanPieces.getSettlementIndexY()));
			CatanPieces.findSettlement(x + 20, y);
			d = getHexLocations(
					CatanPieces.getPositions().get(
							CatanPieces.getSettlementIndexX()),
					CatanPieces.getPositions().get(
							CatanPieces.getSettlementIndexY()));
			CatanPieces.findSettlement(x, y + 20);
			e = getHexLocations(
					CatanPieces.getPositions().get(
							CatanPieces.getSettlementIndexX()),
					CatanPieces.getPositions().get(
							CatanPieces.getSettlementIndexY()));
			if (settlementLocations[c] == false
					&& settlementLocations[d] == false
					&& settlementLocations[e] == false) {
				two = true;
			} else {
				two = false;
			}
		}
		System.out.println(two);
		return two;
	}

	public static boolean[] getSettlementLocations() { //returns settlementLocations arraylist.
		return settlementLocations;
	}
}