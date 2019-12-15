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
                                <th class="text-center">#</th>
                                <th scope="col" class="text-center">Name</th>
                                <th scope="col" class="text-center">Price</th>
                                <th scope="col" class="text-center">Cloth size</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list models as model>
                                <tr>
                                    <th scope="row" class="text-center">${model.id}</th>
                                    <td class="text-center">${model.name}</td>
                                    <td class="text-center">${model.price}$</td>
                                    <td class="text-center">${model.clothSize}</td>
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