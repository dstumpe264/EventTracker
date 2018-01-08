$(document).ready(function(){
	$('h1').css('color', 'red');
})

angular.module('appModule')
.factory('vehicleService', function($http){
	var service = {};
	
	var BASE_URL = "rest/vehicles";
	
	service.index = function(){
		return $http({
			method : 'GET',
			url : BASE_URL
		})
	};
	service.show = function(vid){
		return $http({
			method : 'GET',
			url : BASE_URL + "/" + vid
		})
	};
	service.createVehicle = function(vehicle){
		return $http({
			method : "POST",
			url : BASE_URL,
			headers : {
				'Content-Type' : 'applications/json'
			},
			data : vehicle
		
		})
	};
	service.updateVehicle = function(vehicle){
		return $http({
			method: "PUT",
			url : BASE_URL + "/" + vehicle.id,
			headers : {
				'Content-Type' : 'applications/json'
			},
			data : vehicle		
		})
	};
	service.destroyVehicle = function(vehicle){
		return $http({
			method : "DELETE",
			url : BASE_URL + "/" + vehicle.id
		})
	};
	
	$('.add').on('click', function(e){
		
	})
	
	
	return service;
})