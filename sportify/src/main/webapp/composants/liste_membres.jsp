<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>

<h2 class="interface-titles"> <b>Liste des membres</b> </h2>
<hr class="line">

<div class="table-responsive memberList">
    <table class="table">
        <thead class="memberList-thead">
        <tr>
            <th scope="col">Nom</th>
            <th scope="col">Prénom</th>
            <th scope="col">Date d'inscription</th>
            <th scope="col">Numéro</th>
            <th scope="col">Email</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="i" begin="0" end="3" step="1">
            <tr>
                <td class="">Benzema</td>
                <td class="">Karim</td>
                <td class="">07/02/2020</td>
                <td class="">0620356842</td>
                <td class="">7/12</td>
                <td> <button class="btn btn-primary mb-2" onclick="retirer()"> Retirer </button></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>