<#include "security.ftlh">
<#import "common.ftlh"as c >
<@c.page>
    <#include "navbar.ftlh">
    <div class="container-fluid">
        <div class="row">
            <div class="col-3"></div>
            <div class="col-6">
                <div class="card mt-5 ">
                    <h2 class="card-header text-center ">Clothes
                        <a href="/addCloth" class="btn btn-success mt-2 float-right">Add cloth</a></h2>
                    <div class="card-body">
                        <table class="table table-bordered table-hover">
                            <thead class="thead-dark">
                            <tr>
                                <th class="text-center">#</th>
                                <th scope="col" class="text-center">Name</th>
                                <th scope="col"  class="text-center">Price</th>
                                <th scope="col"  class="text-center">Size</th>
                                <th scope="col" class="text-center">Action</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list clothes as cloth>
                                <tr>
                                    <th class="text-center" scope="row">${cloth.id}</th>
                                    <td class="text-center">${cloth.name}</td>
                                    <td class="text-center">${cloth.price} $</td>
                                    <td class="text-center">${cloth.size} </td>
                                    <td class="text-center">
                                        <a href="/add10cloth/${cloth.id}"
                                           class="btn-sm btn-success mt-1 float-left">Add 10</a>
                                        <a href="/add50cloth/${cloth.id}"
                                           class="btn-sm btn-success mt-1 float-right">Add 50</a>
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