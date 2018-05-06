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
                                var firstSeries = chart.series[0];
                                var secondSeries = chart.series[1];
                                var categories = chart.xAxis[0].categories;
                                var categoriesLength = categories.length;
                                var yAxisValue;

                                RealTimeDataResource.getData().then(function(response) {
                                    var data = response.data;
                                    yAxisValue = data.yAxis;

                                    firstSeries.addPoint([categoriesLength, yAxisValue], false, true);
                                    secondSeries.addPoint([categoriesLength, yAxisValue + 10], false, true);

                                    var dateNow = new Date(data.xAxis);

                                    categories.push(dateNow.getHours() + ':'
                                        + (dateNow.getMinutes() <= 9 ? '0' +dateNow.getMinutes() : dateNow.getMinutes())
                                        + ':' +dateNow.getSeconds());
                                    chart.xAxis[0].setCategories(categories, false);

                                    chart.redraw();
                                });

                            }, 1000);
                        }
                    }
                },
                title: {
                    text : 'Real Time Data'
                },
                xAxis: {
                    categories: ['00:00:00', '00:00:00', '00:00:00', '00:00:00', '00:00:00',
                        '00:00:00', '00:00:00', '00:00:00', '00:00:00', '00:00:00'],
                },
                yAxis : {
                    title : {
                        text : 'Data',
                    },
                },
                series: [{
                    data: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
                }, {
                    data: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
                }]
            })
        }

        return service;
    }
})();