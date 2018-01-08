angular.module('appModule')
.component('vehicleList',{
	templateUrl : 'app/appModule/vehicleList/vehicleList.component.html',
	controllerAs : 'vm',
	controller : function(vehicleService){
		var vm = this;
		
		vm.vehicles = [];
		
		vm.selected = null;
		vm.editVehicle = null;
		vm.addMiles = null;
		
		var index = function(){
			vehicleService.index()
			.then(function(response){
				vm.vehicles = response.data
			})
		};
		vm.show = function(vehicle){
			vm.selected = angular.copy(vehicle);
			vehicleService.show(vm.selected.id)
			.then(function(response){
				vm.vehicles = response.data
				index();
			})
		};
		
		index();

		
		vm.createVehicle = function(vehicle){
			vehicleService.createVehicle(vehicle)
			.then(function(response){
				vm.vehicles = response.data
				index();
			})
			vm.editVehicle = null;
			vm.selected = null;
		};
		
		vm.updateVehicle = function(vehicle){
			console.log(vehicle);
			vehicleService.updateVehicle(vehicle)
			.then(function(response){
				index();
			})
			vm.selected = vm.addMiles;
			vm.addMiles = null;
		};
		
		vm.destroyVehicle = function(vehicle){
			vehicleService.destroyVehicle(vehicle)
			.then(function(response){
				vm.selected = null;
				index();
			})
			
		};
		
		vm.updateMiles= function(vehicle){
			vm.addMiles = angular.copy(vehicle);
		}
		vm.addVehicle = function(){
			vm.selected = null;
			vm.editVehicle = true;
		}
		
		
	}
})