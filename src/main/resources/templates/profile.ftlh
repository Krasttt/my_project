<#include "security.ftlh">
<#import "common.ftlh"as c >
<@c.page>
    <div class="container-fluid">
        <div class="row">
            <div class="col-3"></div>
            <div class="col-6">
                <div class="card mt-5 ">
                    <h2 class="card-header text-center ">${user.name} ${user.surname?if_exists}
                        <a href="/createorder" class="btn btn-success mt-2 float-right">Create order</a></h2>
                    <div class="card-body">
                        <table class="table table-bordered table-hover">

                            <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th scope="col" class="col">Model</th>
                                <th scope="col" class="col">Cloth</th>
                                <th scope="col" class="col">Cutter</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list orders as order>
                                <tr>
                                    <th scope="row">${order.id}</th>
                                    <td>${order.model.name}</td>
                                    <td>${order.cloth.name}</td>
                                    <td>${order.cutter.name}</td>
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