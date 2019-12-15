<#include "security.ftlh">
<#import "common.ftlh"as c >
<@c.page>
    <#include "navbar.ftlh">
    <div class="container-fluid">
        <div class="row">
            <div class="col-3"></div>
            <div class="col-6">
                <div class="card mt-5 ">
                    <h2 class="card-header text-center ">Cutters
                        <a href="/addCutter" class="btn btn-success mt-2 float-right">Add cutter</a></h2>
                    <div class="card-body">
                        <table class="table table-bordered table-hover">
                            <thead class="thead-dark">
                            <tr>
                                <th class="text-center">#</th>
                                <th class="text-center" scope="col" >Name</th>
                                <th class="text-center" scope="col" >Surname</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list cutters as cutter>
                                <tr>
                                    <th class="text-center" scope="row">${cutter.id}</th>
                                    <td class="text-center">${cutter.name}</td>
                                    <td class="text-center">${cutter.surname!}</td>
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