package net.azurewebsites.fakerestapi.authors.api;

import com.netcompany.intrasoft.api.GenericApi;
import com.netcompany.intrasoft.dto.controlresult.ControlResultDto;
import com.netcompany.intrasoft.utils.Test;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import java.util.Map;

public class BooksApi {
    private static final String PATH_BOOKS = "/api/v1/Books";
    final Test test;
    final String url;

    public BooksApi(Test test) {
        this.test = test;
        url = test.envDataConfig().getApplicationUrl() + PATH_BOOKS;
    }

    public ControlResultValidations validate() {
        return new ControlResultValidations(test);
    }

    public ControlResultDto getControlResult(String movementId) {
        final String getControlResultUrl = url + movementId;
        final Map<String, String> params = Map.of("useArchive", "false");
        Response response = GenericApi.apiGenericGetJson(getControlResultUrl, test.context().getTokenCwm(), params);
        response.then().statusCode(HttpStatus.SC_OK);
        return response.getBody().as(ControlResultDto.class);
    }
}
