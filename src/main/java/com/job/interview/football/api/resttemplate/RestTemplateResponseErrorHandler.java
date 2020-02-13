package com.job.interview.football.api.resttemplate;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatus.Series;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import com.job.interview.football.exception.FootballAPIException;
import com.job.interview.football.exception.ResourceNotFoundException;
import com.job.interview.football.exception.TimeOutException;

@Component
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {

	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		return (response.getStatusCode().series() == Series.CLIENT_ERROR
				|| response.getStatusCode().series() == Series.SERVER_ERROR);
	}

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {

		if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
			throw new ResourceNotFoundException();
		} else if (response.getStatusCode() == HttpStatus.GATEWAY_TIMEOUT) {
			throw new TimeOutException();
		} else if (response.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR
				|| response.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR) {
			System.err.println("API connection error - Status code: " + response.getStatusCode() + " - Message: "
					+ response.getStatusText());
			throw new FootballAPIException();
		}

	}

}
