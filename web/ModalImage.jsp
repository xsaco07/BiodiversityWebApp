<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">

    <div class="modal fade" id="id${Observation.observationId}" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">

        <div class="modal-dialog modal-dialog-centered" role="document">

            <div class="modal-content">

                <div class="modal-header">
                    <h4 class="modal-title">Specie: ${Observation.specieName}</h4>
                </div>
                <div class="modal-body">
                    <a href="" style="border: 8px solid #d7d7d7;" class="image fit"><img src="${Observation.imageURL}" width="300" alt=""></a>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </div>
            </div>

        </div>
    </div>

</div>