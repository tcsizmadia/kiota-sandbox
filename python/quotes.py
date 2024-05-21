from client.quotes_api_client import QuotesApiClient
from kiota_abstractions.authentication.anonymous_authentication_provider import (
    AnonymousAuthenticationProvider)
from kiota_http.httpx_request_adapter import HttpxRequestAdapter

async def main():
    auth_provider = AnonymousAuthenticationProvider()
    request_adapter = HttpxRequestAdapter(auth_provider)

    client = QuotesApiClient(request_adapter)

    persons = await client.persons.get()

    for person in persons:
        quotes = await client.quotes.author.by_author_id(person.id).get()
        for quote in quotes:
            print(f"{person.name}: {quote.content}") 

if __name__ == "__main__":
    import asyncio
    asyncio.run(main())