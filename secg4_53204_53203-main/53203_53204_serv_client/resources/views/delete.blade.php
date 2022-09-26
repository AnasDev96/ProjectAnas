@extends('canevas')
@section('title','delete')
@section('delete')

<h2>Choose file to delete</h2>
<form action="/delete" method="post">
    {{ csrf_field() }}
    <select name="file" class="classic">
        @foreach ($files as $file)
        <option value="{{$file}}">{{basename($file)}}</option>
        @endforeach
    </select><br>
    <br>
    <button class="delete">To delete</button>
</form>
<br>
<br>
<br>

<a href="/server" class="button" >Return</a>
@endsection