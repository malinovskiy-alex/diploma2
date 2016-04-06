/**
 * Created by malinovsky on 9/4/2014.
 */
define(function (require) {
    var Backbone = require('backbone'),
        orderFormTemplate = require('text!../../templates/order.form.tpl');
    require('bootstrap');

    var OrderFormView = Backbone.View.extend({
        template: _.template(orderFormTemplate),
        events: {
            'click .cancel': 'closeEditForm',
            'click .add': 'closeEditForm'
        },
        render: function () {
            this.$el.html(this.template(this.model.toJSON()));
            return this;
        },
        openEditForm: function () {
            this.$(".orderForm").modal("show");
        },
        closeEditForm: function (e) {
            e.preventDefault();
            this.$(".orderForm").modal("hide");
        }
    });
    return OrderFormView;
});