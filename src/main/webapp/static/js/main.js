var appChess = angular.module('appChess',[]);


appChess.controller('appCtrl', function($scope, $http){
	
	
	$scope.query = "select distinct ?game where {?game prop:black 'Wilhelm Steinitz'.} LIMIT 100";
	$scope.result = '';
	

	$scope.getSparqlResults = function(){
	    $http({
	        'url' : '/query/',
	        'method' : 'POST',
	        'headers': {'Content-Type' : 'application/json'},
	        'data' : $scope.query
	    }).then(function(data){
	        $scope.result = data;
	        
	        
	    })
	};
});




