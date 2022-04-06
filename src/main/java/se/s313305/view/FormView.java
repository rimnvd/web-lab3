package se.s313305.view;

import se.s313305.DTOConverter;
import se.s313305.controller.InputController;
import se.s313305.controller.InputValidator;
import se.s313305.dto.PointDTO;
import se.s313305.entity.Point;
import se.s313305.service.PointService;
import se.s313305.service.PointServiceJPA;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Named("formView")
@SessionScoped
public class FormView implements Serializable {

    private double inputX;
    private double inputY;
    private double inputR;

    // svg
    private double svgX;
    private double svgY;

    // table dto list
    private List<PointDTO> dtoList;

    @PostConstruct
    private void init() {
        dtoList = new ArrayList<>();
    }

    public double getInputX() {
        return inputX;
    }

    public void setInputX(double x) {
        this.inputX = x;
    }

    public double getInputY() {
        return inputY;
    }

    public void setInputY(double y) {
        this.inputY = y;
    }

    public double getInputR() {
        return inputR;
    }

    public void setInputR(double r) {
        this.inputR = r;
    }

    public double getSvgX() {
        return svgX;
    }

    public void setSvgX(double svgX) {
        this.svgX = svgX;
    }

    public double getSvgY() {
        return svgY;
    }

    public void setSvgY(double svgY) {
        this.svgY = svgY;
    }

    public List<PointDTO> getUserDTOList() {
        List<PointDTO> lst = new ArrayList<>();
        lst.add(PointDTO.newBuilder()
                .setX(inputX)
                .setY(inputY)
                .setR(inputR).build());
        return lst;
    }

    public PointDTO getUserDTOSvg() {
        return PointDTO.newBuilder()
                .setX(svgX)
                .setY(svgY)
                .setR(inputR).build();
    }

    public List<PointDTO> getDtoList() {
        return dtoList;
    }

    public void setDtoList(List<PointDTO> dtoList) {
        this.dtoList = dtoList;
    }
}
