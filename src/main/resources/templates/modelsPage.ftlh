<#include "security.ftlh">
<#import "common.ftlh"as c >
<@c.page>
    <#include "navbar.ftlh">
    <div class="container-fluid">
        <div class="row">
            <div class="col-3"></div>
            <div class="col-6">
                <div class="card mt-5 ">
                    <h2 class="card-header text-center ">Models
                        <a href="/addModel" class="btn btn-success mt-2 float-right">Add model</a></h2>
                    <div class="card-body">
                        <table class="table table-bordered table-hover">
                            <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th scope="col" class="col">Name</th>
                                <th scope="col" class="col">Price</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list models as model>
                                <tr>
                                    <th scope="row">${model.id}</th>
                                    <td>${model.name}</td>
                                    <td>${model.price}</td>
                                </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</@c.page>