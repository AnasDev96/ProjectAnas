@extends('canevas')
@section('title','upload')
@section('upload')


@if (\Session::has('success'))
<div class = "succes">
    <ul>
        <li>{!! \Session::get('success') !!}</li>
    </ul>
</div>
@elseif(\Session::has('error'))
<div class = "succes">
    <ul>
        <li>{!! \Session::get('error') !!}</li>
    </ul>
</div>
@endif
<br>
<br>

<form method="post" enctype="multipart/form-data" action="/upload">
    @csrf
    <input class = "chose" type="file" name="file">
    <br>
    <br>
    <input class = "chose" type="submit" value="upload">
</form>
<br>
<br>
<br>
<br>
<a href="/server" class="button">Return</a>



@endsection