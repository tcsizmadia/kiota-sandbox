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
    from ..models.person import Person
    from .item.persons_item_request_builder import PersonsItemRequestBuilder

class PersonsRequestBuilder(BaseRequestBuilder):
    """
    Builds and executes requests for operations under /persons
    """
    def __init__(self,request_adapter: RequestAdapter, path_parameters: Union[str, Dict[str, Any]]) -> None:
        """
        Instantiates a new PersonsRequestBuilder and sets the default values.
        param path_parameters: The raw url or the url-template parameters for the request.
        param request_adapter: The request adapter to use to execute the requests.
        Returns: None
        """
        super().__init__(request_adapter, "{+baseurl}/persons", path_parameters)
    
    def by_id(self,id: int) -> PersonsItemRequestBuilder:
        """
        Gets an item from the SandboxApiSdk.persons.item collection
        param id: Unique identifier of the item
        Returns: PersonsItemRequestBuilder
        """
        if not id:
            raise TypeError("id cannot be null.")
        from .item.persons_item_request_builder import PersonsItemRequestBuilder

        url_tpl_params = get_path_parameters(self.path_parameters)
        url_tpl_params["id"] = id
        return PersonsItemRequestBuilder(self.request_adapter, url_tpl_params)
    
    async def get(self,request_configuration: Optional[RequestConfiguration] = None) -> Optional[List[Person]]:
        """
        Get a list of all persons
        param request_configuration: Configuration for the request such as headers, query parameters, and middleware options.
        Returns: Optional[List[Person]]
        """
        request_info = self.to_get_request_information(
            request_configuration
        )
        if not self.request_adapter:
            raise Exception("Http core is null") 
        from ..models.person import Person

        return await self.request_adapter.send_collection_async(request_info, Person, None)
    
    def to_get_request_information(self,request_configuration: Optional[RequestConfiguration] = None) -> RequestInformation:
        """
        Get a list of all persons
        param request_configuration: Configuration for the request such as headers, query parameters, and middleware options.
        Returns: RequestInformation
        """
        request_info = RequestInformation(Method.GET, self.url_template, self.path_parameters)
        request_info.configure(request_configuration)
        request_info.headers.try_add("Accept", "application/json")
        return request_info
    
    def with_url(self,raw_url: Optional[str] = None) -> PersonsRequestBuilder:
        """
        Returns a request builder with the provided arbitrary URL. Using this method means any other path or query parameters are ignored.
        param raw_url: The raw URL to use for the request builder.
        Returns: PersonsRequestBuilder
        """
        if not raw_url:
            raise TypeError("raw_url cannot be null.")
        return PersonsRequestBuilder(self.request_adapter, raw_url)
    

