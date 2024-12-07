def urls = [
    'http://www.groovy-lang.org',
    'http://gpars.codehaus.org',
    'http://gr8conf.org/'
]*.toURL()

for (url in urls) {   
    println(url);
}
