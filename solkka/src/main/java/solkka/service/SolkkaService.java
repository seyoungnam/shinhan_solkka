package solkka.service;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import solkka.model.util.ApiTool;

@Service
public class SolkkaService {
	@Autowired
	ApiTool tool;
	
	public JSONObject callApi(JSONObject input) throws Exception {
		return tool.callApi(input);
	}

}