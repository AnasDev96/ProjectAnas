@extends('canevas')
@section('title','download')
@section('download')


<h2> Choose the file to download</h2>

<ol class="rounded-list">
    @forelse($files as $file)
    <li>
        <a href="{{ route('download', basename($file)) }}">
            {{ basename($file) }}
        </a>
    </li>
    @empty
    <li>You have no files</li>
   @endforelse
</ol> 
<br>
<br>
<br>
<a href="/server" class="button">Return</a>
@endsection