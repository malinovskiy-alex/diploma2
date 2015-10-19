/**
 * Created by malinovsky on 9/1/2014.
 */
require.config({
    paths: {
        jquery: 'lib/jquery-2.1.1.min',
        underscore: 'lib/underscore',
        backbone: 'lib/backbone',
        bootstrap: 'lib/bootstrap.min',
        paginator: 'lib/pagination/backbone.paginator',
        text: 'lib/require/text',
        async: 'lib/require/async'
    },
    'shim': {
        'underscore': {
            'exports': '_'
        },
        'bootstrap': {
            'deps': ['jquery'],
            'exports': 'bootstrap'
        },
        'backbone': {
            'deps': ['jquery', 'underscore'],
            'exports': 'Backbone'
        }
    }
});
// convert Google Maps into an AMD module
define('gmaps', ['async!http://maps.google.com/maps/api/js?v=3&sensor=false'],
    function () {
        // return the gmaps namespace for brevity
        return window.google.maps;
    });
require(['views/orders'], function (OrdersView) {
    var app_view = new OrdersView();
});
