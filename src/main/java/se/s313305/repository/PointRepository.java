package se.s313305.repository;

import se.s313305.entity.Point;

import java.util.List;

public interface PointRepository {

    Point addEntity(Point p);

    List<Point> addEntityList(List<Point> pList);

    List<Point> getSessionEntityList();

    List<Point> deleteSessionEntityList();

}
