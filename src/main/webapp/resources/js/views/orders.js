/**
 * Created by malinovsky on 9/4/2014.
 */
define(function (require) {
    var $ = require('jquery'),
        Backbone = require('backbone'),
        _ = require('underscore'),
        gmaps = require('gmaps'),
        OrderList = require('collections/orders'),
        OrderModel = require('models/order'),
        OrderView = require('views/order.view'),
        OrderFormView = require('views/order.form'),
        orderTableTemplate = require('text!../../templates/order.table.tpl'),
        paginationTemplate = require('text!../../templates/order.pagination.tpl');

    return Backbone.View.extend({
        el: '.orders',
        events: {
            'click .new': 'openNewForm',
            'click .first': 'showFirst',
            'click .previous': 'showPrevious',
            'click .last': 'showLast',
            'click .next': 'showNext'
        },
        initialize: function () {
            this.collection = new OrderList();
            this.collection.fetch({});
            this.listenTo(this.collection, "add", this.addOrder);
            this.listenTo(this.collection, "reset", this.render)
        },
        render: function () {
            this.$el.empty();
            this.$el.append(_.template(orderTableTemplate))
            this.collection.forEach(function (item) {
                this.renderOrder(item)
            }, this);
            this.$el.append(_.template(paginationTemplate, this.collection.state))
        },
        renderOrder: function (item) {
            var orderView = new OrderView({model: item});
            $("#orders").append(orderView.render().el);
        },
        addOrder: function (e) {
            e.preventDefault();
            var formData = {};
            $("#order input").each(function (i, el) {
                if ($(el).val() !== '') {
                    formData[el.id] = $(el).val()
                }
            });
            this.collection.create(new OrderModel(formData), {
                success: function (model) {
                    console.log(model)
                }
            });
        },
        openNewForm: function () {
            var orderForm = new OrderFormView({
                model: new OrderModel()
            });
            this.$el.append(orderForm.render().el);
            orderForm.openEditForm();
        },
        showFirst: function () {
            this.collection.getFirstPage()
        },
        showPrevious: function () {
            this.collection.getPreviousPage()
        },
        showNext: function () {
            this.collection.getNextPage()
        },
        showLast: function () {
            this.collection.getLastPage()
        }
    });
});