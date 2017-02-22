package com.capgemini.chessgame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class KnightRules {

	public static final List<KnightMoves> knightMoves = new ArrayList<>(
			Arrays.asList(KnightMoves.UPLEFT, KnightMoves.UPRIGHT, KnightMoves.DOWNLEFT, KnightMoves.DOWNRIGHT,
					KnightMoves.LEFTUP, KnightMoves.LEFTDOWN, KnightMoves.RIGHTUP, KnightMoves.RIGHTDOWN));
}
