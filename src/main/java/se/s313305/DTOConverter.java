package se.s313305;

import se.s313305.dto.PointDTO;
import se.s313305.entity.Point;

public class DTOConverter {

    public static Point dtoToEntity(PointDTO pointDTO) {
        return Point.newBuilder()
                .setX(pointDTO.getX())
                .setY(pointDTO.getY())
                .setR(pointDTO.getR())
                .setHit(pointDTO.getHit())
                .setLocalDateTime(pointDTO.getLocalDateTime())
                .setScriptTime(pointDTO.getScriptTime())
                .setOffset(pointDTO.getOffset())
                .build();
    }

    public static PointDTO entityToDto(Point point) {
        return PointDTO.newBuilder()
                .setX(point.getX())
                .setY(point.getY())
                .setR(point.getR())
                .setHit(point.isHit())
                .setLocalDateTime(point.getLocalDateTime())
                .setScriptTime(point.getScriptTimeSeconds())
                .setOffset(point.getOffset())
                .build();
    }
}
