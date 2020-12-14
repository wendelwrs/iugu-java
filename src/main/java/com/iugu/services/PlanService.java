package com.iugu.services;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.iugu.IuguConfiguration;
import com.iugu.exceptions.IuguException;
import com.iugu.model.Plan;
import com.iugu.responses.PlanResponse;

public class PlanService {

	private IuguConfiguration iugu;
	private final String CREATE_URL = IuguConfiguration.url("/plans");
	private final String FIND_URL = IuguConfiguration.url("/plans/%s");
	private final String FIND_BY_IDENTIFIER_URL = IuguConfiguration.url("/plans/identifier/%s");
	private final String CHANGE_URL = IuguConfiguration.url("/plans/%s");
	private final String REMOVE_URL = IuguConfiguration.url("/plans/%s");

	public PlanService(IuguConfiguration iuguConfiguration) {
		this.iugu = iuguConfiguration;
	}

	public PlanResponse create(Plan plan) throws IuguException {
		Response response = this.iugu.getNewClient().target(CREATE_URL).request().post(Entity.entity(plan, MediaType.APPLICATION_JSON));

		int ResponseStatus = response.getStatus();
		String ResponseText = null;

		response.bufferEntity();

		if (ResponseStatus == 200)
			return response.readEntity(PlanResponse.class);

		// Error Happened
		if (response.hasEntity())
			ResponseText = response.readEntity(String.class);

		response.close();

		throw new IuguException("Error creating plan!", ResponseStatus, ResponseText);
	}

	public PlanResponse find(String id) throws IuguException {
		Response response = this.iugu.getNewClient().target(String.format(FIND_URL, id)).request().get();

		int ResponseStatus = response.getStatus();
		String ResponseText = null;

		response.bufferEntity();

		if (ResponseStatus == 200)
			return response.readEntity(PlanResponse.class);

		// Error Happened
		if (response.hasEntity())
			ResponseText = response.readEntity(String.class);

		response.close();

		throw new IuguException("Error finding plan!", ResponseStatus, ResponseText);
	}

	public PlanResponse findByIdentifier(String id) throws IuguException {
		Response response = this.iugu.getNewClient().target(String.format(FIND_BY_IDENTIFIER_URL, id)).request().get();

		int ResponseStatus = response.getStatus();
		String ResponseText = null;

		response.bufferEntity();

		if (ResponseStatus == 200)
			return response.readEntity(PlanResponse.class);

		// Error Happened
		if (response.hasEntity())
			ResponseText = response.readEntity(String.class);

		response.close();

		throw new IuguException("Error finding plan by identifier!", ResponseStatus, ResponseText);
	}

	public PlanResponse change(String id, Plan plan) throws IuguException {
		Response response = this.iugu.getNewClient().target(String.format(CHANGE_URL, id)).request().put(Entity.entity(plan, MediaType.APPLICATION_JSON));

		int ResponseStatus = response.getStatus();
		String ResponseText = null;

		response.bufferEntity();

		if (ResponseStatus == 200)
			return response.readEntity(PlanResponse.class);

		// Error Happened
		if (response.hasEntity())
			ResponseText = response.readEntity(String.class);

		response.close();

		throw new IuguException("Error changing plan!", ResponseStatus, ResponseText);

	}

	public PlanResponse remove(String id) throws IuguException {
		Response response = this.iugu.getNewClient().target(String.format(REMOVE_URL, id)).request().delete();

		int ResponseStatus = response.getStatus();
		String ResponseText = null;

		response.bufferEntity();

		if (ResponseStatus == 200)
			return response.readEntity(PlanResponse.class);

		// Error Happened
		if (response.hasEntity())
			ResponseText = response.readEntity(String.class);

		response.close();

		throw new IuguException("Error removing plan!", ResponseStatus, ResponseText);
	}

	// TODO Listar os planos
}
