def url_to_filename(url: str) -> str:
    # remove protocol
    if url.startswith("https://"):
        url = url[len("https://"):]
    elif url.startswith("http://"):
        url = url[len("http://"):]
    # remove domain prefix ("www.geeksforgeeks.org/")
    parts = url.split("/", 1)
    if len(parts) > 1:
        path = parts[1]
    else:
        path = ""
    path = path.rstrip("/")
    path = path.replace("/", "_")
    return f"test_{path}.py"

url = input("Enter URL: ")

filename = url_to_filename(url)

with open(filename, "w") as f:
    f.write(f"# {url}\n")