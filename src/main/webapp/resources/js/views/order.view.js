/**
 * Created by malinovsky on 9/4/2014.
 */
define(function(require){
    var $ = require('jquery'),
        Backbone = require('backbone'),
        _ = require('underscore'),
        OrderFormView = require('views/order.form'),
        orderViewTemplate = require('text!../../templates/order.tpl');

    var OrderView = Backbone.View.extend({
        tagName: 'tr',
        template: _.template(orderViewTemplate),
        events: {
            "click .delete": "deleteOrder",
            "click .edit" : "editOrder"
        },
        render: function () {
            this.$el.html(this.template(this.model.toJSON()))
            return this;
        },
        editOrder:function(){
            var orderForm = new OrderFormView({model:this.model});
            this.$el.append(orderForm.render().el);
            orderForm.openEditForm();
        },
        deleteOrder: function () {
            this.model.destroy()
            this.remove()
        }
    });
    return OrderView;
});