package se.s313305.controller;

import se.s313305.entity.Point;

import java.util.Arrays;

public class InputValidator {

    private static final double[] valueX = {-3, -2, -1, 0, 1, 2, 3};

    public static boolean validateSvgEntity(Point p) {
        boolean flagY = p.getY() > -3 && p.getY() < 3;
        boolean flagR = p.getR() > 0.09999 && p.getR() <= 3;
        return flagY && flagR;
    }

    public static boolean validateFormEntity(Point p) {
        boolean flagX = Arrays.binarySearch(valueX, p.getX()) > -1;
        boolean flagR = p.getR() > 0.09999 && p.getR() <= 3;
        return flagX && flagR;
    }
}
