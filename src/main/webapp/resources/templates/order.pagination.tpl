<div align="center">
    <span class="divider">/</span>
        <% if (currentPage > firstPage) { %>
            <a href="#" class="previous">Previous</a>
        <% }else{ %>
            <span>Previous</span>
        <% }%>
        <% if (currentPage < totalPages) { %>
            <a href="#" class="next">Next</a>
        <% } %>
        <% if (firstPage != currentPage) { %>
            <a href="#" class="first">First</a>
        <% } %>
        <% if (lastPage != currentPage) { %>
            <a href="#" class="last">Last</a>
        <% } %>
        <span class="divider">/</span>
        <span class="cell serverhowmany">
            Show
            <a href="#" class="selected">3</a>
            |
            <a href="#" class="">9</a>
            |
            <a href="#" class="">12</a>
            per page
        </span>
        <span class="divider">/</span>
        <span class="cell first records">
            Page: <span class="current"><%= currentPage %></span>
            of
            <span class="total"><%= totalPages %></span>
                        shown
        </span>
    <span class="divider">/</span>
    <span class="cell sort">
        <a href="#" class="orderUpdate btn small">Sort by:</a>
    </span>
    <select id="sortByField">
        <option value="cid">Select a field to sort on</option>
        <option value="ReleaseYear">Release year</option>
        <option value="ShortName">Alphabetical</option>
    </select>
        <button class="btn btn-primary new">New order</button>
    </span>
</div>