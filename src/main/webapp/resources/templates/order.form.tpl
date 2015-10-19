<div class="modal fade orderForm">
        <div class="modal-dialog">
            <div class="modal-content">
                 <div class="modal-header">
                    <a class="close" data-dismiss="modal">×</a>
                    <h3>Client order</h3>
                 </div>
                <div class="modal-body">
 <form role="form" id="order">
            <div class="form-group">
                <label for="clientName">Client Name</label>
                <input class="form-control" id="clientName" value="<%= user.username %>" placeholder="Enter client name and surname"/>
            </div>
            <div class="form-group">
                <label for="clientAddress">Client address</label>
                <input class="form-control" id="clientAddress" value="<%= user.homeAddress %>" placeholder="Enter address"/>
            </div>
            <div class="form-group">
                <label for="clientAddress">Client Phone</label>
                <input class="form-control" id="clientPhone" value="<%= user.phone %>" placeholder="Enter client phone"/>
            </div>
            <div class="form-group">
                 <label for="recipientPhone">Order status</label>
               <input class="form-control" id="status" value="<%= status %>" placeholder="Enter status"/>
            </div>
            <div class="form-group">
                <label for="recipientName">Recipient name</label>
                <input class="form-control" id="recipientName" value="<%= recipientName %>" placeholder="Enter recipient name and surname"/>
            </div>
            <div class="form-group">
                <label for="recipientAddress">Recipient address</label>
                <input class="form-control" id="recipientAddress" value="<%= recipientAddress %>" placeholder="Enter recipient address"/>
            </div>
            <div class="form-group">
                <label for="recipientPhone">Recipient Phone</label>
                <input class="form-control" id="recipientPhone" value="<%= recipientPhone %>" placeholder="Enter recipient phone"/>
            </div>
            <div class="form-group">
                <button class="btn btn-primary add">Save</button>
                <button class="btn btn-danger cancel">Close</button>
            </div>
</form>
                </div>
            </div>
        </div>
</div>