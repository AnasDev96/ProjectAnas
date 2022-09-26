@extends('canevas')
@section('title','Login')
@section('login')


<h1>Login</h1>

<form action="{{route('add.client')}}" method="post">
    {{ csrf_field() }}
    {{method_field("POST")}}
    <div class="form-group">
        <label for="name">email:</label>
        <input type="text" class='form-control' placeholder="Entrez votre mail" name="email" id="email">
    </div>

    <div class="form-group">
        <label for="email">Mot de passe:</label>
        <input type="password" class='form-control' placeholder="Entrez un mot de passe" name="mdp" id="mdp">
    </div>
    <div class="form-group">
        <input type="submit" value="Se connecter" class="btn btn-success">

    </div>
</form>

@endsection