<#include "security.ftlh">
<#import "common.ftlh"as c >
<@c.page>
    <#include "navbar.ftlh">
    <div class="container-fluid">
        <div class="row">
            <div class="col-3"></div>
            <div class="col-6">
                <div class="card mt-5 ">
                    <h2 class="card-header text-center ">${user.name} ${user.surname!}
                        <#if !isAdmin>
                        <a href="/createorder" class="btn btn-success mt-2 float-right">Create order</a>
                        </#if>
                    </h2>
                    <div class="card-body">
                        <table class="table table-bordered table-hover">

                            <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th scope="col" class="text-center">Model</th>
                                <th scope="col" class="text-center">Cloth</th>
                                <th scope="col" class="text-center">Cutter</th>
                                <th scope="col" class="text-center">Status</th>
                                <th scope="col" class="text-center">
                                    <#if isAdmin>
                                        Action
                                    <#else>
                                        Price
                                    </#if>
                                </th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list orders as order>
                                <tr>
                                    <th class="text-center" scope="row">${order.id}
                                    <td class="text-center">${order.model.name}</td>
                                    <td class="text-center">${order.cloth.name}</td>
                                    <td class="text-center">${order.cutter.name}</td>
                                    <td class="text-center">${order.status.name}</td>
                                    <td class="text-center">
                                        <#if isAdmin>
                                            <a href="/removeOrder/${order.id}"
                                               class="btn-sm btn-danger mt-1 float-left">Remove</a>
                                            <a href="/readyOrder/${order.id}"
                                               class="btn-sm btn-success mt-1 float-right">Ready</a>
                                        <#else>
                                            ${order.price!}$
                                        </#if>
                                    </td>
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