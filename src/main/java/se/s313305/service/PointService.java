package se.s313305.service;

import se.s313305.entity.Point;

import java.util.List;

public interface PointService {

    Point addEntity(Point p);

    List<Point> addEntityList(List<Point> pList);

    List<Point> getSessionEntityList();

    List<Point> deleteSessionEntityList();

}
