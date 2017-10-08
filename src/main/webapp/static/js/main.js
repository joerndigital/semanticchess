var appChess = angular.module('appChess',[]);


appChess.controller('appCtrl', function($scope, $http){
	
	
	$scope.query = '';
	$scope.result = '';
	$scope.resultCounter = 0;
	$scope.errorFound = false;
	$scope.error = '';
	
	
	$scope.getSparqlResults = function(){
	    $http({
	        'url' : '/sparql/',
	        'method' : 'POST',
	        'headers': {'Content-Type' : 'application/json'},
	        'data' : $scope.query
	    }).then(function(data){
	    	
	    	if(!(typeof data == undefined)){
		    	$scope.errorFound = false;
		    	$scope.result = data;
		        $scope.error = '';
		        $scope.resultCounter = $scope.result.data.results.bindings.length;	
	    	}else {
	    		$scope.error = data; 
	    	}


	        
	        
	    }).catch(function (err) {

		    	$scope.resultCounter = 0;
		    	$scope.result = "";
		    	$scope.errorFound = true;    	
	    	
	    });
	 
	    
	};
	
	$scope.getQueryResults = function(){
	    $http({
	        'url' : '/query/',
	        'method' : 'POST',
	        'headers': {'Content-Type' : 'application/json'},
	        'data' : $scope.query
	    }).then(function(data){
	    	console.log(data);    
	    	if(!(typeof data == undefined)){
		    	$scope.errorFound = false;
		    	$scope.result = data;
		        $scope.error = '';
		        $scope.resultCounter = $scope.result.data.results.bindings.length;	
	    	}else {
	    		$scope.error = data; 
	    	}


	        
	        
	    }).catch(function (err) {
	    	console.log(data);   
		    	$scope.resultCounter = 0;
		    	$scope.result = "";
		    	$scope.errorFound = true;    	
	    	
	    });
	 
	     
	};
});


// https://codepen.io/vsync/pen/czgrf
var textarea = document.querySelector('textarea');

textarea.addEventListener('keydown', autosize);
             
function autosize(){
  var el = this;
  setTimeout(function(){
    el.style.cssText = 'height:auto';
    // for box-sizing other than "content-box" use:
    // el.style.cssText = '-moz-box-sizing:content-box';
    el.style.cssText = 'height:' + el.scrollHeight + 'px';
  },0);
}




