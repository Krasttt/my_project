<#include "security.ftlh">
<#import "common.ftlh"as c >
<@c.page>
    <#include "navbar.ftlh">
    <div class="container-fluid">
        <div class="row">
            <div class="col-2"></div>
            <div class="col-8">
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
                            <tr>
                                <th> </th>
                                <td class="text-center" >
                                    <form id="model" method="get" action="/profile" class="form-inline">
                                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                        <select form="model" class="form-control col-9" id="model_id" name="model_id">
                                            <option value="">All</option>
                                            <#list models as model>
                                                <option value="${model.id}">${model.name}</option>
                                            </#list>
                                        </select>
                                        <button class="btn btn-outline-success col-2" type="submit">
                                        </button>
                                    </form>
                                </td>
                                <td class="text-center" >
                                    <form id="cloth" method="get" action="/profile" class="form-inline">
                                        <select form="cloth" class="form-control col-9" id="cloth_id" name="cloth_id">
                                            <option value="">All</option>
                                            <#list clothes as cloth>
                                                <option value="${cloth.id}">${cloth.name}</option>
                                            </#list>
                                        </select>
                                        <button class="btn btn-outline-success col-2" type="submit"></button>
                                    </form>
                                </td>
                                <td class="text-center" >
                                    <form id="cutter" method="get" action="/profile" class="form-inline">
                                        <select form="cutter" class="form-control col-9" id="cutter_id" name="cutter_id">
                                            <option value="">All</option>
                                            <#list cutters as cutter>
                                                <option value="${cutter.id}">${cutter.name}</option>
                                            </#list>
                                        </select>
                                        <button class="btn btn-outline-success col-2" type="submit"></button>
                                    </form>
                                </td>
                                <td class="text-center" >
                                    <form id="status" method="get" action="/profile" class="form-inline">
                                        <select form="status" class="form-control col-9" id="status_id" name="status_id">
                                            <option value="">All</option>
                                            <#list statuses as status>
                                                <option value="${status.id}">${status.name}</option>
                                            </#list>
                                        </select>
                                        <button class="btn btn-outline-success col-2" type="submit"></button>
                                    </form>
                                </td>
                                <td class="text-center" ></td>
                            </tr>
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