/**
 * Created by malinovsky on 9/1/2014.
 */
define(function (require) {
    var Backbone = require('backbone');

    var OrderModel = Backbone.Model.extend({
        url: '/addresses',
        defaults: {
            id: '',
            user: '',
            recipientName: '',
            recipientPhone: '',
            recipientAddress: '',
            productName: '',
            orderPrice: 0,
            status: 'Sending'
        }
    });
    return OrderModel;
})
