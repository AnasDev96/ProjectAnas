<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet"   type="text/css" href="{{ asset('css/contri.css') }}">

    <title>@yield('title')</title>
</head>

<body>
<header>
        <a href="/server"><img id="logo" src="{{ asset('img/he2b-esi.jpg') }}" alt="HE2B-ESI"></a>
 <h1> SECG4 - Computer Project  </h1>

    </header>
    <nav>
        <ul class = "user">
            @if (!Auth::guest())
            <li><a>User : {{ Auth::user()->name }} </a> </li>
            <li><a href="{{ url('/logout') }}">Logout </a> </li>
            @else
            @yield('home')
            @endif
        </ul>
    </nav>

    @yield('login')
    @yield('register')
    @yield('serv')
    @yield('upload')
    @yield('delete')
    @yield('download')
<footer>
        <p>SECG4 - Anas Ben Allal  - Paul Zedzian</p>
    </footer>
</body>

</html>