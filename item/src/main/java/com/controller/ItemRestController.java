package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.ItemDao;
import com.model.Item;

@RestController
public class ItemRestController {
	
	@Autowired
	ItemDao itemDao;
	
	@GetMapping("/homeinfo")
	public String gethomeinfo() {
		return "working home";
	}
	@PostMapping("/additem")
	public ResponseEntity addItem(@RequestBody Item i) {
		itemDao.save(i);
		return new ResponseEntity("Item Added",HttpStatus.OK);
	}
	
	@GetMapping("/getitems")
	public List<Item> getItems(){
		return itemDao.findAll();		
	}
	@PatchMapping("/updateitem")
	public ResponseEntity updateItem(@RequestBody Item i) {
		itemDao.save(i);
		return new ResponseEntity("Item Updated",HttpStatus.OK);
	}
	@DeleteMapping("/deleteitem")
	public ResponseEntity deleteItem(@RequestBody Item i){
		itemDao.delete(i);
		return new ResponseEntity("Item deleted",HttpStatus.OK);
	}
	@GetMapping("/findbyid/{id}")
	public Item getaItems(@PathVariable int i){
		Item itm= itemDao.findById(i).get();
		return itm;
	}
}
