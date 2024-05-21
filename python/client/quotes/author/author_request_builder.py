from __future__ import annotations
from kiota_abstractions.base_request_builder import BaseRequestBuilder
from kiota_abstractions.get_path_parameters import get_path_parameters
from kiota_abstractions.request_adapter import RequestAdapter
from typing import Any, Callable, Dict, List, Optional, TYPE_CHECKING, Union

if TYPE_CHECKING:
    from .item.with_author_item_request_builder import WithAuthorItemRequestBuilder

class AuthorRequestBuilder(BaseRequestBuilder):
    """
    Builds and executes requests for operations under /quotes/author
    """
    def __init__(self,request_adapter: RequestAdapter, path_parameters: Union[str, Dict[str, Any]]) -> None:
        """
        Instantiates a new AuthorRequestBuilder and sets the default values.
        param path_parameters: The raw url or the url-template parameters for the request.
        param request_adapter: The request adapter to use to execute the requests.
        Returns: None
        """
        super().__init__(request_adapter, "{+baseurl}/quotes/author", path_parameters)
    
    def by_author_id(self,author_id: int) -> WithAuthorItemRequestBuilder:
        """
        Gets an item from the SandboxApiSdk.quotes.author.item collection
        param author_id: Unique identifier of the item
        Returns: WithAuthorItemRequestBuilder
        """
        if not author_id:
            raise TypeError("author_id cannot be null.")
        from .item.with_author_item_request_builder import WithAuthorItemRequestBuilder

        url_tpl_params = get_path_parameters(self.path_parameters)
        url_tpl_params["authorId"] = author_id
        return WithAuthorItemRequestBuilder(self.request_adapter, url_tpl_params)
    

