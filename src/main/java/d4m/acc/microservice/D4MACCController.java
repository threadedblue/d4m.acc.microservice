package d4m.acc.microservice;

import java.util.SortedSet;

import org.hl7.fhir.emf.Finals.SDS_FORMAT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import d4m.acc.access.AccumuloAccess;

@ComponentScan
@RestController
public class D4MACCController {

	private static final Logger log = LoggerFactory.getLogger(D4MACCController.class);

	private final AccumuloAccess acc;

	@Autowired
	public D4MACCController(AccumuloAccess acc) {
		this.acc = acc;
	}


	@GetMapping("/")
	public String hello() {
		return "Ave Mundus!!";
	}

	@GetMapping("/tables")
	public SortedSet<String> listTables() {
		return acc.listTables();
	}

	@PostMapping(path = "/create", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> createTable(@RequestBody String tableName) {
		acc.createTable(tableName);
		return ResponseEntity.accepted().body(tableName);
	}

	@PostMapping(path = "/createPair", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> createTablePair(@RequestBody String tableName) {
		acc.createTablePair(tableName);
		return ResponseEntity.accepted().body(tableName);
	}

	@PostMapping(path = "/qry", produces = "application/json")
	@ResponseBody
	public ResponseEntity<RCVs> runQuery(@RequestBody String qry) {

		log.info("qry=" + qry);

		String[] rr = { "r1", "r2", "r3" };
		String[] cc = { "c1", "c2", "c3" };
		String[] vv = { "v1", "v2", "v3" };

		RCVs rcvs = new RCVs(rr, cc, vv);
		return ResponseEntity.accepted().body(rcvs);
	}

	@PostMapping(path = "/ins", consumes = MediaType.TEXT_PLAIN_VALUE, produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> insResource(@RequestBody String resource, SDS_FORMAT format, String tableName) {

		acc.insert(resource, format, tableName);

		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
