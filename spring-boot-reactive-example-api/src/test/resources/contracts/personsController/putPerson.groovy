package contracts.personsController

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	description "should return jane doe info."

	request {
		url "/persons"
		method GET()
		body (file("jane.json"))
	}

	response {
		status 200
		body (file("jane.json"))
	}
}
