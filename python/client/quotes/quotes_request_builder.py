from __future__ import annotations
from kiota_abstractions.base_request_builder import BaseRequestBuilder
from kiota_abstractions.base_request_configuration import RequestConfiguration
from kiota_abstractions.get_path_parameters import get_path_parameters
from kiota_abstractions.method import Method
from kiota_abstractions.request_adapter import RequestAdapter
from kiota_abstractions.request_information import RequestInformation
from kiota_abstractions.request_option import RequestOption
from kiota_abstractions.serialization import Parsable, ParsableFactory
from typing import Any, Callable, Dict, List, Optional, TYPE_CHECKING, Union

if TYPE_CHECKING:
    from ..models.quote import Quote
    from .author.author_request_builder import AuthorRequestBuilder

class QuotesRequestBuilder(BaseRequestBuilder):
    """
    Builds and executes requests for operations under /quotes
    """
    def __init__(self,request_adapter: RequestAdapter, path_parameters: Union[str, Dict[str, Any]]) -> None:
        """
        Instantiates a new QuotesRequestBuilder and sets the default values.
        param path_parameters: The raw url or the url-template parameters for the request.
        param request_adapter: The request adapter to use to execute the requests.
        Returns: None
        """
        super().__init__(request_adapter, "{+baseurl}/quotes", path_parameters)
    
    async def get(self,request_configuration: Optional[RequestConfiguration] = None) -> Optional[List[Quote]]:
        """
        Get a list of all quotes
        param request_configuration: Configuration for the request such as headers, query parameters, and middleware options.
        Returns: Optional[List[Quote]]
        """
        request_info = self.to_get_request_information(
            request_configuration
        )
        if not self.request_adapter:
            raise Exception("Http core is null") 
        from ..models.quote import Quote

        return await self.request_adapter.send_collection_async(request_info, Quote, None)
    
    def to_get_request_information(self,request_configuration: Optional[RequestConfiguration] = None) -> RequestInformation:
        """
        Get a list of all quotes
        param request_configuration: Configuration for the request such as headers, query parameters, and middleware options.
        Returns: RequestInformation
        """
        request_info = RequestInformation(Method.GET, self.url_template, self.path_parameters)
        request_info.configure(request_configuration)
        request_info.headers.try_add("Accept", "application/json")
        return request_info
    
    def with_url(self,raw_url: Optional[str] = None) -> QuotesRequestBuilder:
        """
        Returns a request builder with the provided arbitrary URL. Using this method means any other path or query parameters are ignored.
        param raw_url: The raw URL to use for the request builder.
        Returns: QuotesRequestBuilder
        """
        if not raw_url:
            raise TypeError("raw_url cannot be null.")
        return QuotesRequestBuilder(self.request_adapter, raw_url)
    
    @property
    def author(self) -> AuthorRequestBuilder:
        """
        The author property
        """
        from .author.author_request_builder import AuthorRequestBuilder

        return AuthorRequestBuilder(self.request_adapter, self.path_parameters)
    
