/**
 * Created by malinovsky on 9/4/2014.
 */
define(function(require){
    var PaginableCollection = require('paginator'),
        OrderModel = require('models/order');

    var OrderList  = PaginableCollection.extend({
        model: OrderModel,
        url: '/addresses',
        mode: "client",
        state: {
            pageSize: 5,
            // You can use 0-based or 1-based indices, the default is 1-based.
            // You can set to 0-based by setting ``firstPage`` to 0.
            firstPage: 1,

            // Set this to the initial page index if different from `firstPage`. Can
            // also be 0-based or 1-based.
            currentPage: 1

        }

    });
    return OrderList
});