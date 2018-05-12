(function() {
    'use strict';

    angular.module('RealTimeReporting').factory('RealTimeReportingChartService',
        RealTimeReportingChartService);

    RealTimeReportingChartService.$inject = [ 'RealTimeDataResource' ];

    function RealTimeReportingChartService(RealTimeDataResource) {
        var service = {};

        service.populateStackedBarChart = function() {
            var chart = new Highcharts.Chart({
                chart: {
                    type: 'line',
                    renderTo : 'realTimeDataBarChart',
                    events : {
                        load : function() {
                            setInterval(function() {
                                RealTimeDataResource.getData().then(function(response) {
                                    var data = response.data;

                                    for(var key in data){
                                        var series = chart.series.find(x => x.name === key)
                                        if(typeof series === 'undefined' ){
                                            series = chart.addSeries({ name : key });
                                        }

                                        var points = data[key];
                                        series.points = [];
                                        for(var i=0; i<points.length; i++){
                                            series.addPoint([points[i].xAxis, points[i].yAxis], false);
                                        };
                                    }

                                    chart.redraw();
                                });

                            }, 5000);
                        }
                    }
                },
                title: {
                    text : 'Best fitness:'
                },
                xAxis: {
                    categories: [],
                },
                yAxis : {
                    title : {
                        text : 'Data',
                    },
                },
                series: []
            })
        }

        return service;
    }
})();