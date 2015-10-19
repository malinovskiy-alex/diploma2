/**
 * Created by malinovsky on 9/4/2014.
 */
define(function(require){
    var $ = require('jquery'),
        Backbone = require('backbone'),
        Bootstrap = require('bootstrap'),
        orderFormTemplate = require('text!../../templates/order.form.tpl');


    var OrderFormView = Backbone.View.extend({
        template: _.template(orderFormTemplate),
        events:{
            'click .cancel': 'closeEditForm',
            'click .add': 'closeEditForm'
        },
        render: function () {
            this.$el.html(this.template(this.model.toJSON()))
            return this;
        },
        openEditForm:function(){
           this.$(".orderForm").modal("show");
        },
        closeEditForm:function(e){
            e.preventDefault();
            var self = this;
            this.$(".orderForm").modal("hide")
            setTimeout(function(){
                self.remove()
            },300);

        }
    });
    return OrderFormView;
})