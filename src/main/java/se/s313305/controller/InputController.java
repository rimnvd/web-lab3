package se.s313305.controller;

import se.s313305.DTOConverter;
import se.s313305.dto.PointDTO;
import se.s313305.entity.Point;
import se.s313305.service.PointService;
import se.s313305.view.FormView;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Named("inputController")
@SessionScoped
public class InputController implements Serializable {

    @Inject
    @Named("service.pointService")
    PointService pointService;

    @Inject
    @Named("formView")
    private FormView formView;

    public void executeForm() {
        List<PointDTO> dtoList = formView.getUserDTOList();
        List<Point> pointList = dtoList.stream().map(DTOConverter::dtoToEntity)
                .filter(InputValidator::validateFormEntity).collect(Collectors.toList());

        pointList = pointService.addEntityList(pointList);
        // append list
        if (pointList != null) {
            dtoList = pointList.stream().map(DTOConverter::entityToDto).collect(Collectors.toList());
            formView.setDtoList(Stream.concat(formView.getDtoList().stream(), dtoList.stream()).collect(Collectors.toList()));
        }
    }

    public void executeSvg() {
        System.out.println(formView);
        PointDTO pointDTO = formView.getUserDTOSvg();
        Point p = DTOConverter.dtoToEntity(pointDTO);
        if (InputValidator.validateSvgEntity(p)) {
            p = pointService.addEntity(p);
            // append list
            if (p != null) {
                formView.getDtoList().add(DTOConverter.entityToDto(p));
            }
        }
    }

    public void clearTable() {
        List<Point> pList = pointService.deleteSessionEntityList();
        // reduce list
        if (pList != null) {
            List<PointDTO> dtoList = pList.stream().map(DTOConverter::entityToDto).collect(Collectors.toList());
            List<PointDTO> formList = formView.getDtoList();
            formList.removeAll(dtoList);
        }
    }
}
